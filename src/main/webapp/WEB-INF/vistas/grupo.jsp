<%-- 
    Document   : grupo
    Created on : 4/04/2018, 01:20:06 PM
    Author     : JASMIN-SOMA
--%>
<%@include file="bienvenido.jsp" %>
<br/>
<div class="container">   
    <div class="panel-group">
        <div class="panel panel-primary">
            <div class="panel-heading">Listado de Grupos</div>
            <div id="contenidoPantalla" class="panel-body">        
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
                            <input type="text" class="form-control pull-right" style="width:20%" 
                                   id="search" onkeyup="busquedaTbl('tableGrupo');" placeholder="Busqueda">
                        </div>
                        <div class="col-md-6">
                            <!-- Listado de usuarios -->
                            <div class="table-responsive">
                                <table id="tableGrupo" class="table table-striped">
                                    <thead>
                                        <tr>                            
                                            <th>No</th>
                                            <th>CveGrupo</th>
                                            <th>Nombre</th>
                                            <th></th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${lGrupo}" var="gr" varStatus="count"> 
                                            <tr>                               
                                                <td id="nouser">${count.count}</td>
                                                <td>${gr.cveGru}</td>
                                                <td>${gr.nomGru}</td>
                                                <td><button id="mostrarGrupo" onclick="mostrarGrupo();">
                                                        <span class="glyphicon glyphicon-pencil"></span> </button></td>
                                                         <td><button id="mostrarGrupo" onclick="eliminarGrupo();">
                                                        <span class="glyphicon glyphicon-download"></span> </button></td>

                                            </tr>

                                        </c:forEach>

                                    </tbody>

                                </table>

                            </div>                         
                        </div>
                        <div class="col-md-6">
                            <!--Formilario para agregar usuario -->
                            <form class="form-horizontal"  modelAttribute="user" id="frmGrupo">
                                <div class="form-group">
                                    <label class="control-label col-sm-2" for="clave">cveGrupo<b style="color: red" title="Campo Requerido">*</b></label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="cveGru" placeholder="" required>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-2" for="pwd">Nombre Grupo:<b style="color: red" title="Campo Requerido">*</b></label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="nomGru" placeholder="" required>
                                    </div>
                                </div>
                            </form> 
                        <div class="modal-footer">
                            <div class="form-group">
                                <button id="guardarU" type="button" class="btn btn-success" onclick="agregarGrupo();">Guardar</button>
                                <button id="actualizarU" onclick="actualizarGrupo();" class="btn btn-primary" >Actualizar</button>
                                <button type="button" class="btn btn-default" onclick="limpiarForm('frmGrupo');">Limpiar</button>

                            </div>
                        </div>
                    </div>
                </div><!-- 12-->
            </div><!-- row-->
        </div><!--class body -->
    </div><!-- panel-primary-->
</div>  <!-- panel-group-->  
</div><!--class container -->
</body>
</html>
