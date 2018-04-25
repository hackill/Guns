/**
 * 初始化群主详情对话框
 */
var BonggroupInfoDlg = {
    bonggroupInfoData : {}
};

/**
 * 清除数据
 */
BonggroupInfoDlg.clearData = function() {
    this.bonggroupInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
BonggroupInfoDlg.set = function(key, val) {
    this.bonggroupInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
BonggroupInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
BonggroupInfoDlg.close = function() {
    parent.layer.close(window.parent.Bonggroup.layerIndex);
}

/**
 * 收集数据
 */
BonggroupInfoDlg.collectData = function() {
    this
    .set('id')
    .set('code')
    .set('name')
    .set('comment')
    .set('instCode')
    .set('status')
    .set('createTime')
    .set('modifyTime');
}

/**
 * 提交添加
 */
BonggroupInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/bonggroup/add", function(data){
        Feng.success("添加成功!");
        window.parent.Bonggroup.table.refresh();
        BonggroupInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.bonggroupInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
BonggroupInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/bonggroup/update", function(data){
        Feng.success("修改成功!");
        window.parent.Bonggroup.table.refresh();
        BonggroupInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.bonggroupInfoData);
    ajax.start();
}

$(function() {

});
