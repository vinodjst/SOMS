const orders = [
    { id: 101, status: 'shipped', product: 'Laptop' },
    { id: 102, status: 'pending', product: 'Mouse' },
    { id: 103, status: 'pending', product: 'Monitor' },
    { id: 104, status: 'shipped', product: 'Keyboard' },
];

const products = [
    { id: 101, price: 30000, product: 'Laptop' },
    { id: 102, price: 200, product: 'Mouse' },
    { id: 103, price: 5000, product: 'Monitor' },
    { id: 104, price: 150, product: 'Keyboard' },
    { id: 105, price: 150, product: 'Monitor' },
];


function filterOrders(inputStatus) {
    const filteredOrders = orders.filter((order) => order.status === inputStatus)
    console.log(filteredOrders);
    renderOrders(filteredOrders);
}


const ordersListEl = document.getElementById("order-list");

const renderOrders = (orders) => {
    ordersListEl.innerHTML = '';
    orders.forEach((order) => {
        ordersListEl.appendChild(renderSingleOrder(order));
    });
}

const renderSingleOrder = (order) => {
    const liEl = document.createElement("li");
    liEl.textContent = `Order #${order.id}: ${order.product} (${order.status})`;
    liEl.classList.add("order-item");
    return liEl;
}
const searchBox = document.getElementById("search-box");
const productsContainerEl = document.getElementById("productsContainer")
document.addEventListener("keydown", searchProduct);

const searchProduct = () => {
    productsContainerEl.innerHTML = '';
    const searchVal = searchBox.value;

    const searchedProducts = products.filter((product) =>
        product.product.toLowerCase().includes(searchVal.toLowerCase())
    );

   searchedProducts.forEach((prod) => {
        productsContainerEl.innerHTML += `
            <p>${prod.product}</p>
        `
   });
    searchedProducts.forEach((prod) => console.log(prod.product + " " + prod.price) );

}