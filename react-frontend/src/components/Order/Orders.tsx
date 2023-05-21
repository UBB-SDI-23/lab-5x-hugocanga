import { useState, useEffect } from 'react';
import { Customer } from '../../models/Customer';
import { Order } from '../../models/Order';
import { Transaction } from '../../models/Transaction';

const Orders: React.FC = () => {
  const [customers, setCustomers] = useState<Customer[]>([]);
  const [orders, setOrders] = useState<Order[]>([]);
  const [transactions, setTransactions] = useState<Transaction[]>([]);

  useEffect(() => {
    fetch("http://localhost:8081/api/customers")
    .then((res) => res.json())
    .then((data) => {
      console.log(data);
      
    })
  }, []);

  return (
    <div>
      <h2>Orders</h2>
      <table>
        <thead>
          <tr>
            <th>Order ID</th>
            <th>Customer</th>
            <th>Date</th>
            <th>Products</th>
            <th>Total</th>
            <th>Payment Method</th>
            <th>Amount Paid</th>
          </tr>
        </thead>
        <tbody>
          {orders.map((order) => (
            <tr key={order.id}>
              <td>{order.id}</td>
              <td>{customers.find((c) => c.id === order.customerId)?.name}</td>
              <td>{order.date.toLocaleString()}</td>
              <td>
                <ul>
                  {order.products.map((product) => (
                    <li key={product.id}>{product.name}</li>
                  ))}
                </ul>
              </td>
              <td>${order.total.toFixed(2)}</td>
              <td>{transactions.find((t) => t.orderId === order.id)?.paymentMethod}</td>
              <td>${transactions.find((t) => t.orderId === order.id)?.amount.toFixed(2)}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Orders;
