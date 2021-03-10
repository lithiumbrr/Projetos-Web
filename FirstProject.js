const os = require('os')

setInterval(()=>{

const memoriaTotal = parseInt(os.totalmem()/1024/1024)
const memoriaUsada = parseInt(os.freemem()/1024/1024)
const porcentagem = parseInt(memoriaUsada/memoriaTotal*100)

const view = {

    livre: `${memoriaUsada} MegaBytes`,
    total: `${memoriaTotal} MegaBytes`,
    uso: `${porcentagem} %`
}
console.clear()
console.log("Ultilização da Memoria")
console.table(view)
},1000)
