/**
 * 群主管理初始化
 */
var Bonggroup = {
    id: "BonggroupTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Bonggroup.initColumn = function () {
    return [
        {field: 'selectItem', checkboxes: true},
            {title: '主键', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '组编号', field: 'code', visible: true, align: 'center', valign: 'middle'},
            {title: '组名称', field: 'name', visible: true, align: 'center', valign: 'middle'},
            {title: '备注', field: 'comment', visible: true, align: 'center', valign: 'middle'},
            {title: '机构code', field: 'instCode', visible: true, align: 'center', valign: 'middle'},
            {title: '0 表示正常 1表示异常', field: 'status', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'modifyTime', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Bonggroup.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Bonggroup.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加群主
 */
Bonggroup.openAddBonggroup = function () {
    var index = layer.open({
        type: 2,
        title: '添加群主',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/bonggroup/bonggroup_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看群主详情
 */
Bonggroup.openBonggroupDetail = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if (selected.length > 1){
        Feng.info("请选择一条数据进行操作")
    }else {
        if (this.check()) {
            var index = layer.open({
                type: 2,
                title: '群主详情',
                area: ['800px', '420px'], //宽高
                fix: false, //不固定
                maxmin: true,
                content: Feng.ctxPath + '/bonggroup/bonggroup_update/' + Bonggroup.seItem.id
            });
            this.layerIndex = index;
        }
    }
};

/**
 * 删除群主
 */
Bonggroup.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/bonggroup/delete", function (data) {
            Feng.success("删除成功!");
            Bonggroup.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("bonggroupId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询群主列表
 */
Bonggroup.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Bonggroup.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Bonggroup.initColumn();
    var table = new BSTable(Bonggroup.id, "/bonggroup/list", defaultColunms);
    table.setPaginationType("client");
    Bonggroup.table = table.init();
});
