<%-- 
    Document   : alumno
    Created on : 4/04/2018, 01:19:53 PM
    Author     : JASMIN-SOMA
--%>
<%@include file="bienvenido.jsp" %>
<br/>
<div class="container">   
    <div class="panel-group">
        <div class="panel panel-primary">
            <div class="panel-heading">Listado de Alumnos</div>
            <div id="contenidoPantalla" class="panel-body">        
                <div class="row">                            
                    <!-- Listado de alumnos -->
                    <div  class="col-md-12">
                        <div class="form-group">
                            <input type="text" class="form-control pull-right" style="width:20%" 
                                   id="search" onkeyup="busquedaTbl('tableAlumno');" placeholder="Busqueda">
                        </div>
                        <div class="col-md-6">
                            <div class="table-responsive">
                                <table id="tableAlumno" class="table table-striped">
                                    <thead>
                                        <tr>                            
                                            <th>No</th>
                                            <th>CveAlumno</th>
                                            <th>Nombre</th>
                                            <th>Edad</th>
                                            <th>Clave Grupo</th>
                                            <th></th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody id="bodytabla">
                                        <c:forEach items="${lAlumno}" var="alu" varStatus="count"> 
                                            <tr>                            
                                                <td id="nouser">${count.count}</td>
                                                <td>${alu.cveAlu}</td>
                                                <td>${alu.nomAlu}</td>
                                                <td>${alu.edaAlu}</td>
                                                <td>${alu.cveGru.cveGru}</td>
                                                <td><button id="mostrarU" onclick="mostrarAlumno();" class="btn btn-warning">
                                                        <span class="glyphicon glyphicon-pencil"></span> </button></td>
                                                        <td><button id="eliminar" onclick="eliminarAlumno();" class="btn btn-warning">
                                                        <span class="glyphicon glyphicon-download"></span> </button></td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div> 
                        </div>
                        <input type="hidden" name="${_csrf.parameterName}"
                               value="${_csrf.token}" />
                        <div  class="col-md-6">
                            <!--Formilario para agregar alumno -->
                            <form class="form-horizontal"  modelAttribute="alumno" id="frmAlumno">
                                <div class="form-group">
                                    <label class="control-label col-sm-2" for="cveAlu">cveAlumno:</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="cveAlu" placeholder="" required>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-2" for="nombre">Nombre Alumno:</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="nomAlu" placeholder="" required>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-2" for="edad">Edad:</label>
                                    <div class="col-sm-10">
                                        <input type="number" class="form-control" id="edaAlu" placeholder="" >
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label  class="control-label col-sm-2">Grupo:</label>
                                    <div class="col-sm-4">
                                        <!-- consulta catalogo -->
                                        <select id="grupoid" class="form-control">
                                            <option value="0">Seleccione grupo</option>
                                            <c:forEach items="${lGrupo}" var="gr">
                                                <option value="${gr.cveGru}">${gr.nomGru}} </option>
                                            </c:forEach>
                                        </select>                                            
                                    </div>  
                                </div>
                            </form> 
                            <div class="form-group">
                                <button id="guardarU" type="button" class="btn btn-success" onclick="agregarAlumno();">Guardar</button>
                                <button id="actualizarU" onclick="actualizarAlumno();" class="btn btn-primary" >Actualizar</button>
                                <button type="button" class="btn btn-default" onclick="limpiarForm('frmUsuario');">Limpiar</button>

                            </div>
                        </div>
                    </div>
                </div><!-- row-->
            </div><!--class body -->
        </div><!-- panel-primary-->
    </div>  <!-- panel-group-->  
</div><!--class container -->
</body>
</html>
