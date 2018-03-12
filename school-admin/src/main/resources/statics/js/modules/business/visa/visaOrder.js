$(function () {
    $("#jqGrid").jqGrid({
        url: baseBusinessURL + 'visa/order/list',
        datatype: "json",
        colModel: [			
			{ label: 'ID', name: 'id', index: "id", width: 45, key: true },
			{ label: '订单号', name: 'orderNum', width: 110 },
			{ label: '下单人', name: 'userName', width: 45 },
			{ label: '国家名称', name: 'countryName', width: 60 },
            { label: '套餐名称', name: 'comboName', width: 100 },
            { label: '联系人姓名', name: 'contactUserName', width: 60 },
            { label: '联系人电话', name: 'contactUserPhone', width: 80 },
            { label: '联系人EMAIL', name: 'contactUserEmail', width: 100 },
            { label: '购买份数', name: 'buyNum', width: 30 },
            { label: '订单金额', name: 'orderAmount', width: 40 },
            { label: '订单状态', name: 'orderStatus', width: 70, formatter: function(value, options, row){
                if(value === '1'){
                    return '<span class="label label-success">未支付</span>';
                }else if(value === '2'){
                    return '<span class="label label-success">订单取消/成功</span>';
                }else if(value === '3'){
                    return '<span class="label label-success">订单取消/失败</span>';
                }else if(value === '4'){
                    return '<span class="label label-success">支付成功</span>';
                }else if(value === '5'){
                    return '<span class="label label-success">支付失败</span>';
                }else if(value === '6'){
                    return '<span class="label label-success">过期未支付</span>';
                }else if(value === '6'){
                    return '<span class="label label-success">退款成功</span>';
                }else if(value === '6'){
                    return '<span class="label label-success">退款失败</span>';
                }
            }},
            { label: '签证收件类型', name: 'visaType', width: 80 },
            { label: '签证收件地址', name: 'visaAddress', width: 100 },
			{ label: '状态', name: 'delFlag', width: 50, formatter: function(value, options, row){
				return value === "0" ?
					'<span class="label label-success">正常</span>' :
					'<span class="label label-danger">禁用</span>';
			}},
			{ label: '创建时间', name: 'createTime', index: "create_time", width: 85}
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"pageNum",
            rows:"pageSize",
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
    el:'#rrapp',
    data:{
        q:{
            name: null
        },
        showList: true,
        title:null,
        baseInformation:{
            baseInformationId:null,
            name:null,
            description:null,
            enterCountryNum:null,
            stayDay:null,
            validityTime:null,
            comboContent:null,
            handleTime:null,
            visaInterview:"0",
            cashDeposit:null,
            handleRange:null,
            comboDescription:null,
            delFlag:"0"
        }
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function(){
            vm.showList = false;
            vm.title = "新增";
            vm.baseInformation = {visaInterview:"0", delFlag:"0"};
        },
        update: function () {
            var id = getSelectedRow();
            if(id == null){
                return ;
            }

            vm.showList = false;
            vm.title = "修改";

            vm.getBaseInformation(id);
        },
        del: function () {
            var ids = getSelectedRows();
            if(ids == null){
                return ;
            }

            confirm('确定要删除选中的记录？', function(){
                $.ajax({
                    type: "POST",
                    url: baseBusinessURL + "visa/baseInformation/del",
                    contentType: "application/json",
                    data: JSON.stringify(ids),
                    success: function(r){
                        if(r.code == 0){
                            alert('操作成功', function(){
                                vm.reload();
                            });
                        }else{
                            alert(r.msg);
                        }
                    }
                });
            });
        },
        saveOrUpdate: function () {
            var url = vm.baseInformation.baseInformationId == null ? "visa/baseInformation/save" : "visa/baseInformation/update";
            $.ajax({
                type: "POST",
                url: baseBusinessURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.baseInformation),
                success: function(r){
                    if(r.code === 0){
                        alert('操作成功', function(){
                            vm.reload();
                        });
                    }else{
                        alert(r.msg);
                    }
                }
            });
        },
        getBaseInformation: function(id){
            $.get(baseBusinessURL + "visa/baseInformation/info/" + id, function(r){
                vm.baseInformation = r.baseInformation;
            });
        },
        reload: function () {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam','page');
            $("#jqGrid").jqGrid('setGridParam',{
                postData:{'name': vm.q.name},
                page:page
            }).trigger("reloadGrid");
        }
    }
});