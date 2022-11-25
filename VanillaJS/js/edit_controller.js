
function load_form_from_session_storage(myForm){
    let produtoObject = JSON.parse(sessionStorage.produto);
    myForm.nome.value = produtoObject.nome;
    myForm.autor.value = produtoObject.autor;
    myForm.editora.value = produtoObject.editora;
    myForm.categoria.value = produtoObject.categoria;
    myForm.temLojaFisica.value = produtoObject.temLojaFisica;
    myForm.quantidade.value = produtoObject.quantidade;
    myForm.preco.value = String(produtoObject.preco).replace(".",",");
    myForm.dataLancamento.value = produtoObject.dataLancamento;
    myForm.descricao.value = produtoObject.descricao;
    sessionStorage.removeItem("produto");
    

}
function prepare_jason_to_request (myForm){
    const formData = new FormData(myForm);
    const dataJson = {}
    formData.forEach((value,key) =>(dataJson[key] = value));
    console.log(dataJson);
    dataJson["preco"] = dataJson["preco"].replace(",",".");
    if(dataJson["temLojaFisica"] == 'N'){
        dataJson["quantidade"] = 0  
        }
    return JSON.stringify(dataJson);
}


function incluir_produto(myForm){
    let div_msg = document.getElementById("msg");
    fetch("http://localhost:8080/produtos",{
        headers:{
            "content-Type": "application/json"
        },
        body:prepare_jason_to_request(myForm),
            method:"POST"
    })
    .then(res =>{
        if(res.status == 201){
            div_msg.innerHTML = 
            "<div class='alert alert-success' role='alert'>"+
                "Produto Cadastrado com sucesso."+
                "</div>"
            myForm.reset();
        }else{
            div_msg.innerHTML = 
            "<div class='alert alert-danger' role='alert>"+
                "Erro ao incluir o produto"+ res +
                "</div>"
        }
    })
    .catch(err => {
        div_msg.innerHTML =
        "<div class='alert alert-danger' role='alert>"+
            "Erro ao incluir o produto"+ err +
        "</div>"
    })
}

function alterar_produto(myForm){
    let produtoId = sessionStorage.produtoId;
    let div_msg = document.getElementById("msg");
    let url = "http://localhost:8080/produtos/"+ produtoId;

    fetch(url,{
        headers:{
            "content-Type": "application/json"
        },
        body:prepare_jason_to_request(myForm),
            method:"PUT"
    })
    .then(res =>{
        if(res.status == 200){
            div_msg.innerHTML = 
            "<div class='alert alert-success' role='alert'>"+
                "Produto alterado com sucesso."+
                "</div>"
            myForm.reset();
        }else{
            div_msg.innerHTML = 
            "<div class='alert alert-danger' role='alert>"+
                "Erro ao alterar o produto"+ res +
                "</div>"
        }
    })
    .catch(err => {
        div_msg.innerHTML =
        "<div class='alert alert-danger' role='alert>"+
            "Erro ao alterar o produto"+ err +
        "</div>"
    })
}

window.onload = function(){
    let myForm = document.getElementById("idform");

    if(!sessionStorage.getItem("produto")){
        myForm.addEventListener("submit",function(e){
            e.preventDefault();
            incluir_produto(myForm);
        });
    }else{
        load_form_from_session_storage(myForm);
        myForm.addEventListener("submit",function(e){
            e.preventDefault();
            alterar_produto(myForm);
            
        });
    }

    document.getElementById("btnvoltar").addEventListener("click",function(e){
        e.preventDefault;
        window.location.replace("listarProdutos.html");
    });
    


}