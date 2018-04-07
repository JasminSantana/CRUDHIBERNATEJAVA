/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
});
function limpiarForm(frm) {
    document.getElementById(frm).reset();
}
function busquedaTbl(tabla) {
    var tableReg = document.getElementById(tabla);
    var searchText = document.getElementById('search').value.toLowerCase();
    console.log(searchText);
    for (var i = 1; i < tableReg.rows.length; i++) {
        var cellsOfRow = tableReg.rows[i].getElementsByTagName('td');
        var found = false;
        for (var j = 0; j < cellsOfRow.length && !found; j++) {
            var compareWith = cellsOfRow[j].innerHTML.toLowerCase();
            if (searchText.length === 0 || (compareWith.indexOf(searchText) > -1)) {
                found = true;
            }
        }
        if (found) {
            tableReg.rows[i].style.display = '';
        } else {
            tableReg.rows[i].style.display = 'none';
        }
    }
}
function agregarGrupo() {
    var nombre = $("#cveGru").val();
    var clave = $("#nomGru").val();
    var datos = [nombre, clave];
    $.ajax({
        url: "grupo/agregarGrupo",
        data: {datos: datos},
        dataType: 'html',
        type: 'POST',
        success: function (retorno) {
            //alert(retorno);
            switch (retorno) {
                case 'errorDato':
                    alert("Los datos no se procesaron correctamente");
                    break;
                case 'error':
                    alert("Se ha producido un error en el servidor");
                    break;
                case 'exito':
                    //carga lo que se indica en id DIV
                     location.href="grupo";
                    break;
                case 'errorAcceso':
                    alert("No ha iniciado sesion");
                    break;
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert("Se ha producido un error en el servidor");
        }
    });//ajax
}
function mostrarGrupo(){
     $("#tableGrupo tbody").on('click', 'tr', function () {
        var claveGru = $('td', this).eq(1).text();
        $("#cveGru").val(claveGru);
        var nombreGru = $('td', this).eq(2).text();
        $("#nomGru").val(nombreGru);
    });
}
function actualizarGrupo() {
     var clave = $("#cveGru").val();
    var nombre = $("#nomGru").val();
    var datos = [clave, nombre];
    var datos = [clave,nombre];
    $(document).ajaxSend(function (e, xhr, options) {
        var token = $("input[name='_csrf']").val();
        var cabecera = "X-CSRF-TOKEN";
        xhr.setRequestHeader(cabecera, token);
    });
    $.ajax({
        url: "grupo/actualizarGrupo",
        data: {datos: datos},
        dataType: 'html',
        type: 'POST',
        success: function (retorno) {
            //alert(retorno);
            switch (retorno) {
                case 'errorDato':
                    alert("Los datos no se procesaron correctamente");
                    break;
                case 'error':
                    alert("Se ha producido un error en el servidor");
                    break;
                case 'exito':
                     //alert("Datos correctos");
                     location.href="grupo";
                    break;
                case 'errorAcceso':
                    alert("No ha iniciado sesion");
                    break;
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert("Se ha producido un error en el servidor");
        }
    });
}
function eliminarGrupo() {
    $("#tableGrupo tbody").on('click', 'tr', function () {
        var idCve= $('td', this).eq(1).text();
        var datos = [idCve];
        $(document).ajaxSend(function (e, xhr, options) {
            var token = $("input[name='_csrf']").val();
            var cabecera = "X-CSRF-TOKEN";
            xhr.setRequestHeader(cabecera, token);
        });
        $.ajax({
            url: "grupo/eliminarGrupo",
            data: {datos: datos},
            dataType: 'html',
            type: 'POST',
            success: function (retorno) {
                //alert(retorno);
                switch (retorno) {
                    case 'errorDato':
                        alert("Los datos no se procesaron correctamente");
                        break;
                    case 'error':
                        alert("Se ha producido un error en el servidor");
                        break;
                    case 'exito':
                     location.href="grupo";
                        break;
                    case 'errorAcceso':
                        alert("No ha iniciado sesion");
                        break;
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert("Se ha producido un error en el servidor");
            }
        });
    });
}
/**/

function agregarAlumno() {
    var claveA = $("#cveAlu").val();
    var nomA = $("#nomAlu").val();
    var edadA = $("#edaAlu").val();
var cveGrup = $("#grupoid").val();
    var datos = [claveA, nomA,edadA,cveGrup];
    $.ajax({
        url: "alumno/agregarAlumno",
        data: {datos: datos},
        dataType: 'html',
        type: 'POST',
        success: function (retorno) {
            //alert(retorno);
            switch (retorno) {
                case 'errorDato':
                    alert("Los datos no se procesaron correctamente");
                    break;
                case 'error':
                    alert("Se ha producido un error en el servidor");
                    break;
                case 'exito':
                    //carga lo que se indica en id DIV
                     location.href="alumno";
                    break;
                case 'errorAcceso':
                    alert("No ha iniciado sesion");
                    break;
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert("Se ha producido un error en el servidor");
        }
    });//ajax
}
function mostrarAlumno(){
     $("#tableAlumno tbody").on('click', 'tr', function () {
        var claveAlu = $('td', this).eq(1).text();
        $("#cveAlu").val(claveAlu);
        var nombreAlu = $('td', this).eq(2).text();
        $("#nomAlu").val(nombreAlu);
            var edaAlu = $('td', this).eq(3).text();
        $("#edaAlu").val(edaAlu);
         var cveGru = $('td', this).eq(4).text();
        $("#grupoid").val(cveGru);
    });
}
function actualizarAlumno() {
    var claveA = $("#cveAlu").val();
    var nomA = $("#nomAlu").val();
    var edadA = $("#edaAlu").val();
var cveGrup = $("#grupoid").val();
    var datos = [claveA, nomA,edadA,cveGrup];
    $(document).ajaxSend(function (e, xhr, options) {
        var token = $("input[name='_csrf']").val();
        var cabecera = "X-CSRF-TOKEN";
        xhr.setRequestHeader(cabecera, token);
    });
    $.ajax({
        url: "alumno/actualizarAlumno",
        data: {datos: datos},
        dataType: 'html',
        type: 'POST',
        success: function (retorno) {
            //alert(retorno);
            switch (retorno) {
                case 'errorDato':
                    alert("Los datos no se procesaron correctamente");
                    break;
                case 'error':
                    alert("Se ha producido un error en el servidor");
                    break;
                case 'exito':
                     //alert("Datos correctos");
                     location.href="alumno";
                    break;
                case 'errorAcceso':
                    alert("No ha iniciado sesion");
                    break;
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert("Se ha producido un error en el servidor");
        }
    });
}
function eliminarAlumno() {
    $("#tableAlumno tbody").on('click', 'tr', function () {
        var idCve= $('td', this).eq(1).text();
        $("#cveAlu").val(idCve);
        var datos = [idCve];
        $(document).ajaxSend(function (e, xhr, options) {
            var token = $("input[name='_csrf']").val();
            var cabecera = "X-CSRF-TOKEN";
            xhr.setRequestHeader(cabecera, token);
        });

        $.ajax({
            url: "alumno/eliminarAlumno",
            data: {datos: datos},
            dataType: 'html',
            type: 'POST',
            success: function (retorno) {
                //alert(retorno);
                switch (retorno) {
                    case 'errorDato':
                        alert("Los datos no se procesaron correctamente");
                        break;
                    case 'error':
                        alert("Se ha producido un error en el servidor");
                        break;
                    case 'exito':
                     location.href="alumno";
                        break;
                    case 'errorAcceso':
                        alert("No ha iniciado sesion");
                        break;
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert("Se ha producido un error en el servidor");
            }
        });
    });
}