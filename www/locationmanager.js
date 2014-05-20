cordova.define("cordova/plugin/deviceSpace", function(require, exports, module) {
    var exec = require('cordova/exec');
    
    var DeviceSpace = function() {};

    DeviceSpace.prototype.alert = function(successCallback, errorCallback) {
        return cordova.exec(successCallback,
                            errorCallback,
                            'DeviceSpace',
                            'gpsAlert',
                            []);
    };
    var deviceSpace = new DeviceSpace();
    module.exports = deviceSpace;
});