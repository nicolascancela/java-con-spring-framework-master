var urlService = "/api/provincia/";


function getProvincia(idProvincia) {
    var urlServiceBuscarPorId = urlService + idProvincia;
    $.get(urlServiceBuscarPorId)
            .done(mostrar)
            .fail(mostrarNoEncontrado);
}

function mostrar(provincia) {
    var ventanaModal = $('#ventana');
    ventanaModal.find('.modal-title').text(provincia.nombre);
    ventanaModal.find('.modal-body').text("La provincia es: " + provincia.nombre);
    $('#ventana').appendTo("body").modal('show');
}

function mostrarNoEncontrado() {
    alert("No se encontró la provincia");
}

function bindearEventosABotones() {
    $("#boton1").on("click", function () {
        getProvincia(1);
    });

    $("#boton2").on("click", function () {
        $('.alert').toggle();
        var alerta = $('.alert');
        alerta.find('alert alert-success alert-dismissible').text("Ya se busco la provincia!");
    });


    $("#botonEnviar").on("click", function () {
        var id = $("#txtIDProvincia").val();
        getProvincia(id);
    });
}

$(document).ready(function () {
    bindearEventosABotones();

});