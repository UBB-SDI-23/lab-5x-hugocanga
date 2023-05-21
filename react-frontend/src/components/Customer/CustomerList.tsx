import { useState, useEffect } from "react";
import { Table } from "react-bootstrap";
import axios from "axios";
import { Customer } from "../../models/Customer";

export const CustomerList = () => {
  const [customers, setCustomers] = useState<Customer[]>([]);

  useEffect(() => {
    axios.get<Customer[]>("http://localhost:8080/customers").then((response) => {
      setCustomers(response.data);
    });
  }, []);

  return (
    <div>
      <h1>Customers</h1>
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
          </tr>
        </thead>
        <tbody>
          {customers.map((customer) => (
            <tr key={customer.id}>
              <td>{customer.id}</td>
              <td>{customer.name}</td>
              <td>{customer.email}</td>
              <td>{customer.phone}</td>
            </tr>
          ))}
        </tbody>
      </Table>
    </div>
  );
};
