/* Visitant v0.1.0
*  Visitant is Java Spring Framework based analystic program for tracks website traffic by it install on own server.
*  Copyright @ 2019. Jangho Bae<khanorder@gmail.com>. All rights reserved.
*  used opensource - jQuery v3.2.1 (https://jquery.com/)
*                  - Fingerprintjs2 2.1.0 (https://github.com/Valve/fingerprintjs2)
*                  - UAParser.js v0.7.20 (https://github.com/faisalman/ua-parser-js)
* */
var _vsto = _vsto || {};
if (typeof $ == "undefined" && typeof jQuery == "undefined") {
    console.log("visitantjs must be required to need jQuery.");
} else if (typeof _vsto._rt == "string") {
    if (!_vsto._rt) {
        console.log("visitantjs must be defined root url.");
    } else if (typeof Fingerprint2 != "function") {
        console.log("visitantjs must be required to need fingerprintjs.");
    } else if (typeof UAParser != "function") {
        console.log("visitantjs must be required to need UAParser.");
    } else {
        if (typeof _vsto._log != "string" || !_vsto._log) _vsto._log = "/visitant/log";
        (function($){
            var extensions = {
                browser : [
                    [/(whale)\/([\d\.]+)/i],
                    [/(kakaotalk)[ ]{1}([\d\.]+)/i],
                    ["name", "version"]
                ]
            };
            var UA = new UAParser(extensions);
            var fpOpt = {
                excludes: {
                    audio: true,
                    fonts: true,
                    fontsFlash: true
                }
            }
            var visitant = {
                userAgent: UA.getResult(),
                title: document.title,
                url: location.href,
                protocol: location.protocol.replace(/:/g, ""),
                host: location.hostname,
                port: location.port,
                path: location.pathname,
                parameter: location.search,
                local_time: new Date()
            };
            var vst_keys = [
                "language", "timezone", "timezoneOffset",
                "platform", "screenResolution", "availableScreenResolution",
                "webglVendorAndRenderer"
            ];
            if (window.requestIdleCallback) {
                requestIdleCallback(function () {
                    Fingerprint2.get(fpOpt, function (br) {
                        var values = br.map(function (br) {
                            if (vst_keys.indexOf(br.key) >= 0) {
                                visitant[br.key] = br.value;
                                if (br.key === "enumerateDevices") {
                                    var eVal = [];
                                    if (typeof br.value == "string") {
                                        eVal = br.value;
                                    } else {
                                        for (var i in br.value) {
                                            if (br.value[i].indexOf("default") < 0) {
                                                var dinfo = br.value[i].split(";");
                                                br.value[i] = "";
                                                for (var j in dinfo) {
                                                    if (dinfo[j].indexOf("gid=") < 0) {
                                                        br.value[i]+= dinfo[j];
                                                    }
                                                }
                                                eVal.push(br.value[i]);
                                            }
                                        }
                                    }
                                    visitant[br.key] = eVal;
                                    return eVal;
                                } else {
                                    return br.value;
                                }
                            }
                        });
                        visitant["hash"] = Fingerprint2.x64hash128(values.join(""));
                        $.ajax({
                            type: "post",
                            url: _vsto._rt + _vsto._log,
                            dataType: "json",
                            data: { visitant: JSON.stringify(visitant) },
                            error: function (jqXHR, textStatus, errorThrown) {
                                console.log(jqXHR);
                                console.log("textStatus: " + textStatus);
                                console.log("errorThrown: " + errorThrown);
                            }
                        })
                    })
                })
            } else {
                setTimeout(function () {
                    Fingerprint2.get(fpOpt, function (br) {
                        var values = $.map(br, function (br, br_idx) {
                            if (vst_keys.indexOf(br.key) >= 0) {
                                visitant[br.key] = br.value;
                                if (br.key === "enumerateDevices") {
                                    var eVal = [];
                                    if (typeof br.value == "string") {
                                        eVal = br.value;
                                    } else {
                                        for (var i in br.value) {
                                            if (br.value[i].indexOf("default") < 0) {
                                                var dinfo = br.value[i].split(";");
                                                br.value[i] = "";
                                                for (var j in dinfo) {
                                                    if (dinfo[j].indexOf("gid=") < 0) {
                                                        br.value[i]+= dinfo[j];
                                                    }
                                                }
                                                eVal.push(br.value[i]);
                                            }
                                        }
                                    }
                                    visitant[br.key] = eVal;
                                    return eVal;
                                } else {
                                    return br.value;
                                }
                            }
                        });
                        visitant["hash"] = Fingerprint2.x64hash128(values.join(""));
                        $.ajax({
                            type: "post",
                            url: _vsto._rt + _vsto._log,
                            dataType: "json",
                            data: { visitant: JSON.stringify(visitant) },
                            error: function (jqXHR, textStatus, errorThrown) {
                                console.log(jqXHR);
                                console.log("textStatus: " + textStatus);
                                console.log("errorThrown: " + errorThrown);
                            }
                        })
                    })
                }, 500)
            }
        })(jQuery)
    }
}