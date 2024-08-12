// URL
const apiUrl = 'http://localhost:8080/fiapeats/produto';

async function getProdutos() {
  try {
    const response = await fetch(apiUrl, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json'
      }
    });

    if (!response.ok) {
      throw new Error(`Erro: ${response.status} ${response.statusText}`);
    }
    const responseData = await response.json();

    console.log('Resposta da API:', responseData);
    createEventItems(responseData);
  } catch (error) {
    console.error('Erro ao enviar requisição:', error);
  }
}

function createEventItems(apiResponse) {
  const container = document.getElementById('divItens');
  container.innerHTML = ''; 

  apiResponse.forEach(item => {
    const itemDiv = document.createElement('div');
    itemDiv.classList.add('item');

    itemDiv.innerHTML = `
      <div class="row">
        <div class="col-lg-3">
          <div class="image">
            <img src="${item.imagemUrl}" alt="">
          </div>
        </div>
        <div class="col-lg-9">
          <ul>
            <li>
              <span class="category">${item.nome}</span>
              <h5>${item.descricao}</h5>
            </li>
            <li>
              <span>ID:</span>
              <h6>${item.id}</h6>
            </li>
            <li>
              <span>CATEGORIA:</span>
              <h6>${item.categoria}</h6>
            </li>
            <li>
              <span>VALOR:</span>
              <h6>R$ ${item.valor}</h6>
            </li>
          </ul>
          <a href="#"><i class="fa fa-angle-right"></i></a>
        </div>
      </div>
    `;
    container.appendChild(itemDiv);
  });
}
getProdutos();
