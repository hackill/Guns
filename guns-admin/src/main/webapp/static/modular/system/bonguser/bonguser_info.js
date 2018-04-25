/**
 * 初始化用户详情对话框
 */
var BonguserInfoDlg = {
    bonguserInfoData : {}
};

/**
 * 清除数据
 */
BonguserInfoDlg.clearData = function() {
    this.bonguserInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
BonguserInfoDlg.set = function(key, val) {
    this.bonguserInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
BonguserInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
BonguserInfoDlg.close = function() {
    parent.layer.close(window.parent.Bonguser.layerIndex);
}

/**
 * 收集数据
 */
BonguserInfoDlg.collectData = function() {
    this
    .set('id')
    .set('code')
    .set('name')
    .set('gender')
    .set('birthday')
    .set('height')
    .set('phoneNumber')
    .set('type')
    .set('comment')
    .set('status')
    .set('groupId')
    .set('instId')
    .set('createTime')
    .set('modifyTime');
}

/**
 * 提交添加
 */
BonguserInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/bonguser/add", function(data){
        Feng.success("添加成功!");
        window.parent.Bonguser.table.refresh();
        BonguserInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.bonguserInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
BonguserInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/bonguser/update", function(data){
        Feng.success("修改成功!");
        window.parent.Bonguser.table.refresh();
        BonguserInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.bonguserInfoData);
    ajax.start();
}

$(function() {

});
