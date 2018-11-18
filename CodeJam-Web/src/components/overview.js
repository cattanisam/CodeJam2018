import axios from 'axios'

var fronendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort

var AXIOS = axios.create({
  baseURL: backendURL,
  headers: {'Access-Control-Allow-Origin': frontEndUrl}
})

export default{
    name: 'prob-list',
    data(){
        return{
            records: [],
            displayedRecords: [],
            errorRecords: ''
        }
    },

created: function() {
    AXIOS.get(`/Calculation/mapData/`)
    .then(reponse => {
        this.records = response.data;
        this.displayedRecords = response.data;
    })
    .catch(e => {
        this.errorRecords = e;
    });
}, 
methods: {
    getData: function() {
        AXIOS.post(`/Calculation/mapData/`)
    .then(reponse => {
        this.records = response.data;
        this.displayedRecords = response.data;
    })
    .catch(e => {
        this.errorRecords = e;
        console.log(errorMsg);
    });
    }
}
}