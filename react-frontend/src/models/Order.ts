import { Product } from "./Product";

export interface Order {
    id: number;
    customerId: number;
    products: Product[];
    total: number;
    date: string;
  }