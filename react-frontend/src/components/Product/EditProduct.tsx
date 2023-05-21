import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import { Button, Form, FormGroup, Input, Label } from 'reactstrap';
import axios from 'axios';
import { Product } from '../../models/Product';

const EditProduct = () => {
  const { id } = useParams<{ id: string }>();
  const navigate = useNavigate();
  const [product, setProduct] = useState<Product>({
    id: 1,
    name: '',
    description: '',
    price: 0,
  });

  useEffect(() => {
    axios.get<Product>(`http://localhost:8080/api/products/${id}`)
      .then((response) => {
        setProduct(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }, [id]);

  const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = event.target;
    setProduct({ ...product, [name]: value });
  };

  const handleUpdate = () => {
    axios.put(`http://localhost:8080/api/products/${id}`, product)
      .then(() => {
        navigate('/');
      })
      .catch((error) => {
        console.error(error);
      });
  };

  return (
    <Form>
      <FormGroup>
        <Label for="name">Name</Label>
        <Input type="text" name="name" id="name" value={product.name} onChange={handleChange} />
      </FormGroup>
      <FormGroup>
        <Label for="description">Description</Label>
        <Input type="text" name="description" id="description" value={product.description} onChange={handleChange} />
      </FormGroup>
      <FormGroup>
        <Label for="price">Price</Label>
        <Input type="number" name="price" id="price" value={product.price} onChange={handleChange} />
      </FormGroup>
      <Button color="primary" onClick={handleUpdate}>Update</Button>
    </Form>
  );
};

export default EditProduct;
