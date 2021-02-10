function bindearEventosABotones() {
    $("#boton1").on("click", function () {
        //alert("Esto es una prueba!");
        $('#ventana').appendTo("body").modal('show');
    });


    $("#boton2").on("click", function () {
        $('.alert').toggle();
    });
}

$(document).ready(function () {
    bindearEventosABotones();
});