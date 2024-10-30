import axios from 'axios';
import { Farm, TourPackage, ServiceOrder, User } from '../types';

const api = axios.create({
  baseURL: process.env.NEXT_PUBLIC_API_URL
});

export const farmService = {
  getFarms: () => api.get<Farm[]>('/farms'),
  getFarmById: (id: string) => api.get<Farm>(`/farms/${id}`),
  searchFarms: (params: {
    breed?: string;
    location?: string;
    specialties?: string[];
  }) => api.get<Farm[]>('/farms/search', { params })
};

export const tourService = {
  getTours: (params?: {
    farmId?: string;
    startDate?: Date;
    endDate?: Date;
    priceRange?: [number, number];
  }) => api.get<TourPackage[]>('/tours', { params }),
  createTourBooking: (tourId: string, customerId: string) =>
    api.post<ServiceOrder>('/tours/book', { tourId, customerId })
};

export const orderService = {
  createOrder: (order: Partial<ServiceOrder>) => 
    api.post<ServiceOrder>('/orders', order),
  updateOrderStatus: (orderId: string, status: string) =>
    api.patch<ServiceOrder>(`/orders/${orderId}/status`, { status }),
  getCustomerOrders: (customerId: string) =>
    api.get<ServiceOrder[]>(`/orders/customer/${customerId}`)
}; 