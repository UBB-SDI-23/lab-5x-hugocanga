import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";
import { Order } from "../../models/Order";
import { Product } from "../../models/Product";


const OrderDetails: React.FC = () => {
  const [order, setOrder] = useState<Order>();
  const { id } = useParams();

  useEffect(() => {
    axios.get<Order>(`/api/orders/${id}`).then((response) => {
      setOrder(response.data);
    });
  }, [id]);

  return (
    <div>
      {order && (
        <div>
          <h1>Order Details</h1>
          <p>
            <strong>ID:</strong> {order.id}
          </p>
          <p>
            <strong>Customer ID:</strong> {order.customerId}
          </p>
          <h2>Products</h2>
          <ul>
            {order.products.map((product: Product) => (
              <li key={product.id}>
                {product.name} - {product.price}
              </li>
            ))}
          </ul>
          <p>
            <strong>Total:</strong> {order.total}
          </p>
          <p>
            <strong>Date:</strong> {order.date}
          </p>
        </div>
      )}
    </div>
  );
};

export default OrderDetails;
