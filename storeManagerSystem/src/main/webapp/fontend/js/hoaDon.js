var app = angular.module('HoaDonForm', []);
// app.controller('ctrl', function($scope, $window) {
// $scope.idKhachHang_err = "";
// $scope.ngayLap_err = "";
// $scope.soLuongSP_err = "";
// $scope.diemTichLuy_err = "";
// $scope.tienKhuyenMai_err = "";
// $scope.tongDiemTichLuy_err = "";
// $scope.tongTien_err = "";
//	
// // $scope.btnCreate = function() {
// // if($scope.flagUpdate == 1){
// // update($scope)
// // }else{
// // create($scope);
// // }
// // }
//	
// $scope.btnGetById = function(id){
// getById($scope,$window, id);
// }
//	
// $scope.btnClear = function(){
// clear($scope);
// }
//	
// $scope.btnDelete = function(id){
// remove($scope, $window, id);
// }
//	
// });

// export Excel (S)
// Code goes here
app
		.factory(
				'Excel',
				function($window) {
					var uri = 'data:application/vnd.ms-excel;base64,', template = '<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>', base64 = function(
							s) {
						return $window.btoa(unescape(encodeURIComponent(s)));
					}, format = function(s, c) {
						return s.replace(/{(\w+)}/g, function(m, p) {
							return c[p];
						})
					};
					return {
						tableToExcel : function(tableId, worksheetName) {
							var table = $(tableId), ctx = {
								worksheet : worksheetName,
								table : table.html()
							}, href = uri + base64(format(template, ctx));
							return href;
						}
					};
				}).controller(
				'ctrl',
				function(Excel, $timeout, $scope, $window) {

					$scope.exportToExcel = function(tableId) { // ex:
																// '#my-table'
						var exportHref = Excel.tableToExcel(tableId,
								'WireWorkbenchDataExport');
						$timeout(function() {
							location.href = exportHref;
						}, 100); // trigger download
					}

					$scope.idKhachHang_err = "";
					$scope.ngayLap_err = "";
					$scope.soLuongSP_err = "";
					$scope.diemTichLuy_err = "";
					$scope.tienKhuyenMai_err = "";
					$scope.tongDiemTichLuy_err = "";
					$scope.tongTien_err = "";
					$scope.listCheckBox = "";
					$scope.listCheckBox1 = "";
					$scope.checkboxModel = {
						value1 : true,
						value2 : false
					};

					$scope.btnGetById = function(id) {
						getById($scope, $window, id);
					}

					$scope.btnClear = function() {
						clear($scope);
					}

					$scope.btnCreate = function() {
						dangKy($scope);
					}

					$scope.btnDelete = function(id) {
						remove($scope, $window, id);
					}

					$scope.btnXoaDong = function() {
						xoaDong($scope);
					}

					$scope.btnPhanAnh = function() {
						angular.forEach($scope.selected1, function(item) {
							if (item == "false") {
								// Do not thing
							} else {
								$scope.listCheckBox1 = $scope.listCheckBox1
										+ "," + item;
							}
						});
						phanAnh($scope);
					}

				});
// export Excel (S)

function phanAnh($scope) {
	if ($scope.listCheckBox1 != "") {
		var url = "/storeManagerSystem/bill/phanAnh/" + $scope.listCheckBox1;
	} else {
		var url = "/storeManagerSystem/bill/phanAnh/0";
	}
	document.getElementById("HoaDonForm").action = url;
	document.getElementById("HoaDonForm").method = "POST";
	document.getElementById("HoaDonForm").submit();
}

function getById($scope, $windown, id) {
	var url = "/storeManagerSystem/bill/getById/" + id;
	document.getElementById("HoaDonForm").action = url;
	document.getElementById("HoaDonForm").method = "POST";
	document.getElementById("HoaDonForm").submit();
}

function clear($scope) {
	if (confirm("Bạn có muốn hủy?")) {
		document.getElementById("HoaDonForm").action = "/storeManagerSystem/bill/init";
		document.getElementById("HoaDonForm").method = "POST";
		document.getElementById("HoaDonForm").submit();
	}
}

function xoaDong($scope) {
	angular.forEach($scope.selected, function(item){
		if(item == "false"){
			//Do not thing
		}else{
			$scope.listCheckBox = $scope.listCheckBox + ","+ item;
		}
	});
	if($scope.listCheckBox != ""){
		document.getElementById("HoaDonForm").action = "/storeManagerSystem/bill/xoaDong/"+$scope.listCheckBox;
		document.getElementById("HoaDonForm").method = "POST";
		document.getElementById("HoaDonForm").submit();
	}else {
		alert("Chọn dòng để xóa.")
	}
}

function dangKy($scope) {
	var valid = true;
	var reg = new RegExp('^[0-9]+$');
	var len = $scope.lstSize;
	for (var i = 0; i < len; i++) {
		if ($scope.chiTietHoaDonRowForms[i].soLuongSP == "") {
			$scope.soLuongSP_err = "Hãy nhập số lượng."
			valid = false;
			break;
		}
		if (!reg.test($scope.chiTietHoaDonRowForms[i].soLuongSP)) {
			$scope.soLuongSP_err = "Số lượng phải là số."
			valid = false;
			break;
		}
		if ($scope.chiTietHoaDonRowForms[i].soLuongSP < 1) {
			$scope.soLuongSP_err = "Số lượng phải có giá trị từ 1."
			valid = false;
			break;
		}

	}
	if ($scope.lstSize > 0) {
		if (true == valid) {
			if (confirm("Bạn có muốn đăng ký?")) {
				document.getElementById("HoaDonForm").action = "/storeManagerSystem/bill/insert";
				document.getElementById("HoaDonForm").method = "POST";
				document.getElementById("HoaDonForm").submit();
			}
		}
	} else {
		alert("Chọn sản phẩm để để đăng kí.")
	}
}

function remove($scope, $windown, id) {
	if (confirm("Bạn có muốn xóa?")) {
		var url = "/storeManagerSystem/bill/delete/" + id;
		document.getElementById("HoaDonForm").action = url;
		document.getElementById("HoaDonForm").method = "POST";
		document.getElementById("HoaDonForm").submit();
	}
}
