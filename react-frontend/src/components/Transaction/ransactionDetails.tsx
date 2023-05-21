import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";
import { Transaction } from "../../models/Transaction";



export default function TransactionDetails() {
  const [transaction, setTransaction] = useState<Transaction | null>(null);
  const { id } = useParams();

  useEffect(() => {
    axios.get<Transaction>(`http://localhost:8080/transactions/${id}`)
      .then((response) => {
        setTransaction(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, [id]);

  return (
    <div>
      {transaction ? (
        <div>
          <h1>Transaction Details</h1>
          <p>ID: {transaction.id}</p>
          <p>Order ID: {transaction.orderId}</p>
          <p>Payment Method: {transaction.paymentMethod}</p>
          <p>Amount: {transaction.amount}</p>
          <p>Date: {transaction.date}</p>
        </div>
      ) : (
        <p>Loading...</p>
      )}
    </div>
  );
}
