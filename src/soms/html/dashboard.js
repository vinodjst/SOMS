const orders = [
    { id: 101, status: 'shipped', product: 'Laptop' },
    { id: 102, status: 'pending', product: 'Mouse' },
    { id: 103, status: 'pending', product: 'Monitor' },
    { id: 104, status: 'shipped', product: 'Keyboard' }
];

const showOrders = (type) => {
    let output = "";

    orders.forEach(o => {
        if (type === 'all' || o.status === type) {
            output += `<p>Order #${o.id} - ${o.product} (${o.status})</p>`;
        }
    });

    document.getElementById("ordersList").innerHTML = output;
};