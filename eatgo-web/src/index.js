(async () =>{
    const url = 'http://localhost:8080/restaurants';
    const response = await fetch(url);
    const restaurants = await response.json();

    const element = document.getElementsById('app');
    element.innerHTML = JSON.stringify(restaurants);

})();