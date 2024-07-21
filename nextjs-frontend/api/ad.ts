// api/ad.ts
import axiosInstance from './';

interface IAd {
  id: number;
  title: string;
  description: string;
  amount: number;
  status: string;
}

interface IAdsResponse {
  data: IAd[];
  message: string;
  responseDate: string;
  success: boolean;
}

export const getAds = async (): Promise<IAdsResponse> => {
  const response = await axiosInstance.get('/ads');
  return response.data;
};
