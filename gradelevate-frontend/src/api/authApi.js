import axiosInstance from './axiosInstance';

export const registerUser = (data) =>
  axiosInstance.post('/auth/register', data);

export const loginUser = (data) =>
  axiosInstance.post('/auth/login', data);

export const forgotPassword = (email) =>
  axiosInstance.post('/auth/forgot-password', { email });

export const resetPassword = (token, newPassword) =>
  axiosInstance.post('/auth/reset-password', { token, newPassword });

export const validateResetToken = (token) =>
  axiosInstance.get(`/auth/validate-token?token=${token}`);
 