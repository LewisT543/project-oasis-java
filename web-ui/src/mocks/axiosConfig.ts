import axios from 'axios';
import MockAdapter from 'axios-mock-adapter';
import {mockApplicantResponse} from "./mock-data/mockApplicantResponse.ts";
import {mockPropertyResponse} from "./mock-data/mockPropertyResponse.ts";

const isMock = import.meta.env.DEV;

const axiosInstance = axios.create();

console.log(`isMock ${isMock}`)

if (isMock) {
  const mockAdapter = new MockAdapter(axiosInstance);
  mockAdapter.onGet(import.meta.env.VITE_PROPERTY_API_URL).reply(200, mockPropertyResponse)
  mockAdapter.onGet(import.meta.env.VITE_APPLICANT_API_URL).reply(200, mockApplicantResponse)
}

export default axiosInstance;
