<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootbox.min.js" type="text/javascript"></script>
<script>
$("#btnLoggout").click(function(){
    bootbox.confirm({
        message: "Você quer mesmo sair?",
        buttons: {
            confirm: {
                label: 'Confirmar',
                className: 'btn-success'
            },
            cancel: {
                label: 'Cancelar',
                className: 'btn-default'
            }
        },
        callback: function(result){
            if (result != 1)
                return;
            window.location = "logout";
        }
    });
});  
</script>