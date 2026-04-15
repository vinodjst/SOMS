const orders = [
    { id: 101, status: 'shipped', product: 'Laptop' },
    { id: 102, status: 'pending', product: 'Mouse' },
    { id: 103, status: 'pending', product: 'Monitor' },
    { id: 104, status: 'shipped', product: 'Keyboard' }
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