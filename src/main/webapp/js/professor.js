function carregaListaDeProfessores(){
    fetch("rest-professor")
    .then(response => response.json())
    .then(professores => {

        var tabela = professores.map(professor => (
            `<tr>
            <th scope="row">${professor.id}</th>
            <td>${professor.nome}</td>
            <td>
                <a class="btn btn-danger" onClick="excluirProfessor(${professor.id});" href="#" role="button">Excluir</a>
            </td>
        </tr>`
        ))
 
        return tabela.join('');
    }).then(tabela => {
        var tbody = document.getElementById('lista-de-professores');
        tbody.innerHTML = tabela;
    });
}

function excluirProfessor(id){
    var divAlert = document.getElementById('alertas');
    divAlert.innerHTML = "";
    fetch("rest-professor?id_professor="+id, {
        method:"delete"
    })
    .then(response => response.json())
    .then(json => {
        if(json.erro){
            divAlert.innerHTML = `<div class="alert alert-warning" role="alert">${json.erro}</div>`;
        }else{
            divAlert.innerHTML = `<div class="alert alert-success" role="alert">${json.sucesso}</div>`;          
        }
        carregaListaDeProfessores();
    })
}