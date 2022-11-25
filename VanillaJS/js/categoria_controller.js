
function save_data_sessionstorage_redirect(data, produtoId){
    sessionStorage.setItem("produto",JSON.stringify(data));
    sessionStorage.setItem("produtoId", produtoId);
    window.location.replace("produto.html");

}

function detalhar(link_detalhar){
    let produtoId = link_detalhar.parentNode.previousSibling.previousSibling.textContent;
    let url = "http://localhost:8080/produtos/"+ produtoId;
    fetch(url,{
        method:"GET"
    })
    .then(res => res.json())
    .then(data =>save_data_sessionstorage_redirect(data, produtoId))
}


function listar (){
    let nomepesquisa = document.getElementById("nomepesquisa");
    sessionStorage.setItem("filtroPesquisa",nomepesquisa.value);
    let table_body = document.getElementById("table_body");
    let div_msg = document.getElementById("msg");
    div_msg.innerHTML = "";
    table_body.innerHTML = "";
    let url = "http://localhost:8080/produtos/categoria?categoria="+nomepesquisa.value;
    fetch(url,{
        method:"GET"
    })
    .then(res => res.json())
    .then(data => {
        Object.entries(data).forEach(([key,value]) => {
            let row = table_body.insertRow(-1); 
            let cell_codigo = row.insertCell(0);
            let cell_nome = row.insertCell(1);
            let cell_autor = row.insertCell(2);
            let cell_editora = row.insertCell(3);
            let cell_categoria = row.insertCell(4);
            let cell_quantidade = row.insertCell(5);
            cell_codigo.innerHTML = value.codigo;
            cell_nome.innerHTML = value.nome;
            cell_autor.innerHTML = value.autor;
            cell_editora.innerHTML = value.editora;
            cell_categoria.innerHTML = value.categoria;
            cell_quantidade.innerHTML = value.quantidade;
        })
        document.getElementById("table_head").style.display = "table-header-group";
    })

}
window.onload = function(){
    let load_type = window.performance.getEntriesByType("navigation")[0].type;
    if(sessionStorage.filtroPesquisa){
        if(load_type == "navigate"){
            document.getElementById("nomepesquisa").value = sessionStorage.filtroPesquisa;
            
        }else{ // reload
            sessionStorage.removeItem("filtroPesquisa");
        }
    }


    document.getElementById("btnconsultar").addEventListener("click",function(e){
        e.preventDefault();
        listar();
    });

    
}