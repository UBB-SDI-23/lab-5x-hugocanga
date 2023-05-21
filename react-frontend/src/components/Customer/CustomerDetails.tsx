import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";
import { Customer } from "../../models/Customer";

const CustomerDetails = () => {
  const { id } = useParams<{ id: string }>();
  const [customer, setCustomer] = useState<Customer>();

  useEffect(() => {
    axios.get<Customer>(`/api/customers/${id}`)
      .then(response => setCustomer(response.data))
      .catch(error => console.log(error));
  }, [id]);

  if (!customer) {
    return <div>Loading...</div>;
  }

  return (
    <div>
      <h2>Customer Details</h2>
      <div>
        <strong>Name:</strong> {customer.name}
      </div>
      <div>
        <strong>Email:</strong> {customer.email}
      </div>
      <div>
        <strong>Address:</strong> {customer.address}
      </div>
      <div>
        <strong>Phone:</strong> {customer.phone}
      </div>
    </div>
  );
};

export default CustomerDetails;
