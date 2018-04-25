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
        {field: 'selectItem', radio: true},
            {title: '主键', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '用户编号', field: 'code', visible: true, align: 'center', valign: 'middle'},
            {title: '用户姓名', field: 'name', visible: true, align: 'center', valign: 'middle'},
            {title: '0:male;1:female;2:others', field: 'gender', visible: true, align: 'center', valign: 'middle'},
            {title: '出生年', field: 'birthday', visible: true, align: 'center', valign: 'middle'},
            {title: '出生年', field: 'height', visible: true, align: 'center', valign: 'middle'},
            {title: '电话号码', field: 'phoneNumber', visible: true, align: 'center', valign: 'middle'},
            {title: '用户类型 暂无用途', field: 'type', visible: true, align: 'center', valign: 'middle'},
            {title: '备注', field: 'comment', visible: true, align: 'center', valign: 'middle'},
            {title: '0：正常', field: 'status', visible: true, align: 'center', valign: 'middle'},
            {title: 'groupId', field: 'groupId', visible: true, align: 'center', valign: 'middle'},
            {title: 'institutionId 机构Id', field: 'instId', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'modifyTime', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Bonguser.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
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
        ajax.set("bonguserId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询用户列表
 */
Bonguser.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Bonguser.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Bonguser.initColumn();
    var table = new BSTable(Bonguser.id, "/bonguser/list", defaultColunms);
    table.setPaginationType("client");
    Bonguser.table = table.init();
});
