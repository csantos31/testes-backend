module.exports = {
    index(req, res){
        let valorReal = req.headers.valor;
        
        if(valorReal != undefined){
            valorReal = valorReal.replace(',','.');
            valorReal = valorReal.replace(/[^\d.-]/g, ''); 
            
            valorDolar = parseFloat(0.19 * valorReal).toFixed(2);
            ValorEuro =  parseFloat(0.16 * valorReal).toFixed(2);
            valorIndi = parseFloat(13.85 * valorReal).toFixed(2);
    
            const moedasConvertidas = {
                'ValorReal': parseFloat(valorReal).toFixed(2),
                'ValorDolarAmericano': valorDolar,
                'ValorEuro':ValorEuro,
                'ValorRupeeIndiano': valorIndi
            }
            res.send(JSON.stringify(moedasConvertidas));
        }else{
            res.status(400).send('O valor não pode ser nulo');
        }

    }
};