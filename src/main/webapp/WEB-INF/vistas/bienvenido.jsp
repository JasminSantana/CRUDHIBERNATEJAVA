<%-- 
    Document   : bienvenido
    Created on : 4/04/2018, 01:21:40 PM
    Author     : JASMIN-SOMA
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="<c:url value= '/static/jquery-3.2.1.min.js'/>" type="text/javascript"></script>
        <script src="<c:url value= '/static/jquery-1.10.2.js'/>" type="text/javascript"></script>
        <script src="<c:url value='/static/bootstrap.min.js'/>" type="text/javascript"></script>
         <link href="<c:url value='/static/bootstrap.css'/>" rel="stylesheet"/> 
        <link href="<c:url value='/static/bootstrap.min.css'/>" rel="stylesheet" />        
        <script src="<c:url value='/static/index.js'/>" type="text/javascript"></script>
        <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">    
        <title>Bienvenido</title>
    </head>
    <body>
        <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Administrar catalogos</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="<c:url value='/alumno'/>">Alumno</a></li>
      <li><a href="<c:url value='/grupo'/>">Grupo</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="<c:url value='/bienvenido'/>"><span class="glyphicon glyphicon-circle-arrow-left"></span>Regresar</a></li>
      <li><a href="<c:url value='/bienvenido'/>"><span class="glyphicon glyphicon-refresh"></span>Recargar</a></li>
    </ul>
  </div>
</nav>
                  
  
