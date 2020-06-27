import ConfigApi from '@/services/ConfigApi';
import axios from 'axios';
var processos = [];



function findProcesso (processoId) {
  return produtos[findProductKey(processoId)];
}

function findProcessoKey (processoId) {
  for (var key = 0; key < produtos.length; key++) {
    if (produtos[key].id == processoId) {
      return key;
    }
  }
}

var ProcessoService = {
    findAll(fn) {
      axios
        .get(ConfigApi.urlApi+'/processos')
        .then(response => fn(response))
        .catch(error => console.log(error))
    },
  
    findById(id, fn) {
      axios
        .get(ConfigApi.urlApi+'/processos/' + id)
        .then(response => fn(response))
        .catch(error => console.log(error))
    },
  
    create(processo, fn) {
      axios
        .post(ConfigApi.urlApi+'/processos', processo)
        .then(response => fn(response))
        .catch(error => console.log(error))
    },
  
    update(id, processo, fn) {
      axios
        .put(ConfigApi.urlApi+'/processos/' + id, processo)
        .then(response => fn(response))
        .catch(error => console.log(error))
    },
  
    deleteProduct(id, fn) {
      axios
        .delete(ConfigApi.urlApi+'/processos/' + id)
        .then(response => fn(response))
        .catch(error => console.log(error))
    }
  }

  export default ProcessoService;