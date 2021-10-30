

var BTC_binance_ask, BTC_binance_bid, BTC_gemini_ask, BTC_gemini_bid, ETH_binance_ask, ETH_binance_bid, ETH_gemini_ask, ETH_gemini_bid
var binanceURL='http://localhost:8080/Binance?symbol='
var geminiURL='http://localhost:8080/Gemini?symbol='


function updateRecommended(){
    BTC_binance_ask = document.getElementById("BTC_bin_ask").innerHTML
    BTC_binance_bid = document.getElementById("BTC_bin_bid").innerHTML
    BTC_gemini_ask = document.getElementById("BTC_gem_ask").innerHTML
    BTC_gemini_bid = document.getElementById("BTC_gem_bid").innerHTML

    ETH_binance_ask = document.getElementById("ETH_bin_ask").innerHTML
    ETH_binance_bid = document.getElementById("ETH_bin_bid").innerHTML
    ETH_gemini_ask = document.getElementById("ETH_gem_ask").innerHTML
    ETH_gemini_bid = document.getElementById("ETH_gem_bid").innerHTML

    if(BTC_binance_ask < BTC_gemini_ask){
        document.getElementById("recBTCBuy").innerHTML = "Binance"
    }
    else{
        document.getElementById("recBTCBuy").innerHTML = "Gemini"
    }

    if(BTC_binance_bid > BTC_gemini_bid){
        document.getElementById("recBTCSell").innerHTML = "Binance"
    }
    else{
        document.getElementById("recBTCSell").innerHTML = "Gemini"
    }

    if(ETH_binance_ask < ETH_gemini_ask){
        document.getElementById("recETHBuy").innerHTML = "Binance"
    }
    else{
        document.getElementById("recETHBuy").innerHTML = "Gemini"
    }

    if(ETH_binance_bid > ETH_gemini_bid){
        document.getElementById("recETHSell").innerHTML = "Binance"
    }
    else{
        document.getElementById("recETHSell").innerHTML = "Gemini"
    }

}

function fetchData(){
    var prom_binBTC = fetch(binanceURL + 'BTCUSD')
        .then(res => {
            return res.json()
        })
        .then(data => {
            console.log(data)
            document.getElementById("BTC_bin_bid").innerHTML = data.bidPrice
            document.getElementById("BTC_bin_ask").innerHTML = data.askPrice

        })





    var prom_gemBTC = fetch(geminiURL + 'BTCUSD')
        .then(res => {
            return res.json()
        })
        .then(data => {
            console.log(data)
            document.getElementById("BTC_gem_bid").innerHTML = data.bid
            document.getElementById("BTC_gem_ask").innerHTML = data.ask

        })


    var prom_binETH = fetch(binanceURL + 'ETHUSD')
        .then(res => {
            return res.json()
        })
        .then(data => {
            console.log(data)
            document.getElementById("ETH_bin_bid").innerHTML = data.bidPrice
            document.getElementById("ETH_bin_ask").innerHTML = data.askPrice

        })


    var prom_gemETH = fetch(geminiURL + 'ETHUSD')
        .then(res => {
            return res.json()
        })
        .then(data => {
            console.log(data)
            document.getElementById("ETH_gem_bid").innerHTML = data.bid
            document.getElementById("ETH_gem_ask").innerHTML = data.ask

        })
    
        
    updateRecommended()
    

    var timeoutPromise = new Promise((resolve, reject) => {
        setTimeout(resolve, 2000, 'Timeout Done')
    })



    Promise.all(
        [prom_binBTC, prom_gemBTC, prom_binETH, prom_gemETH, timeoutPromise]).then(values=>{
            fetchData()
        })


}

fetchData()




