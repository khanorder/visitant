<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="robots" content="noindex, nofollow" />
	<meta name="subject" content="" />
	<meta name="copyright" content="" />
	<title>visitant-example</title>
</head>
<body>
<script type="text/javascript" src="<c:url value="/src/plugins/jquery/jquery-3.2.1.min.js"/>"></script>
<script>
    var _vsto = _vsto || {};
    (function() {
        var _rt =(("https:" === document.location.protocol) ? "https" : "http") + "://" + location.host;
        _vsto._rt = _rt;
        var _log = "/log.do";
        _vsto._log = _log;
        var d = document, g = d.createElement("script"), s = d.getElementsByTagName("script")[0]; g.type = "text/javascript";
        g.defer = true; g.async = true; g.src = _rt + "/dist/visitant.min.js"; s.parentNode.insertBefore(g, s);
    })();
</script>
</body>
</html>