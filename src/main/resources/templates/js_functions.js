//VALIDANDO CREDENCIAIS DO LOGIN
function login(){
    var user_email = document.getElementById("login_usuario");
    var user_senha = document.getElementById("login_senha");
    var str_email = user_email.value;
    var str_senha = user_senha.value;
    var email_arroba = str_email.indexOf('@');
    if( email_arroba < 2 || !str_email.includes('.com', email_arroba+3) || str_email.length < 6 ){
        alert("Por favor entre com um e-mail válido");
        user_email.focus();
        return false;
    }
    if( str_senha.length < 4 ){
        alert("O padrão de senha exige, no mínimo, 3 caracteres");
        user_senha.focus();
        return false;
    }
    return true;
}
