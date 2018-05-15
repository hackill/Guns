/**
 * 用户管理初始化
 */
var Bonguser = {
    id: "BonguserTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Bonguser.initColumn = function () {
    return [
        {field: 'selectItem', checkboxes: true},
        {title: '编号',field:'num', align:'center', visible: true, valign: 'middle'},
        {title: '主键', field: 'id', visible: false, align: 'center', valign: 'middle'},
        {title: '用户编号', field: 'code', visible: false, align: 'center', valign: 'middle'},
        {title: '姓名', field: 'name', visible: true, align: 'center', valign: 'middle'},
        {title: '电话号码', field: 'phoneNumber', visible: false, align: 'center', valign: 'middle'},
        {title: '性别', field: 'gender', visible: true, align: 'center', valign: 'middle'},
        {title: '出生年', field: 'birthday', visible: false, align: 'center', valign: 'middle'},
        {title: '身高', field: 'height', visible: false, align: 'center', valign: 'middle'},
        {title: '备注', field: 'comment', visible: false, align: 'center', valign: 'middle'},
        {
            title: '状态',
            field: 'status',
            visible: true,
            align: 'center',
            valign: 'middle',
            // formatter: test
        },
        {title: '手环mac地址', field: 'bong_mac', visible: true, align: 'center', valign: 'middle',formatter: test},
        {title: '手环nfc编号', field: 'nfc_code', visible: false, align: 'center', valign: 'middle'},
        {title: '班级', field: 'bName', visible: true, align: 'center', valign: 'middle'},
        {title: '机构', field: 'iName', visible: true, align: 'center', valign: 'middle'},
        {title: '创建时间', field: 'createTime', visible: false, align: 'center', valign: 'middle'},
        {title: '修改时间', field: 'modifyTime', visible: false, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Bonguser.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if (selected.length == 0) {
        Feng.info("请先选中表格中的某一记录！");
        return false;
    } else {
        Bonguser.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加用户
 */
Bonguser.openAddBonguser = function () {
    var index = layer.open({
        type: 2,
        title: '添加用户',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/bonguser/bonguser_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看用户详情
 */
Bonguser.openBonguserDetail = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if (selected.length > 1){
        Feng.info("请选择一条数据进行操作")
    }else{
        if (this.check()) {
            var index = layer.open({
                type: 2,
                title: '用户详情',
                area: ['800px', '420px'], //宽高
                fix: false, //不固定
                maxmin: true,
                content: Feng.ctxPath + '/bonguser/bonguser_update/' + Bonguser.seItem.id
            });
            this.layerIndex = index;
        }
    }
};

/**
 * 删除用户
 */
Bonguser.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/bonguser/delete", function (data) {
            Feng.success("删除成功!");
            Bonguser.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("bonguserId", this.seItem.id);
        ajax.start();
    }
};
/**
 * 查询表单提交参数对象
 * @returns {{}}
 */
Bonguser.formParams = function () {
    var queryData = {};

    queryData['condition'] = $("#condition").val();

    return queryData;
}

/**
 * 查询用户列表
 */
Bonguser.search = function () {
    Bonguser.table.refresh({query: Bonguser.formParams()});
};

$(function () {
    var defaultColunms = Bonguser.initColumn();
    var table = new BSTable(Bonguser.id, "/bonguser/list", defaultColunms);
    table.setPaginationType("service");
    table.setQueryParams(Bonguser.formParams());
    Bonguser.table = table.init();
});

function test(value, row, index) {
    // alert(value + ", " + row['status'] + ", " + index);

    // return row['status'];
    if(row["bong_mac"] == undefined){
        return [
            '<button type="button" class="btn btn-primary " onclick="Bonguser.openAddBonguser()" id="">' +
            '<i class="fa fa-plus"></i>&nbsp;绑定' +
            ' </button>'
        ].join('');

    }else{
        return row['bong_mac'];
    }

}