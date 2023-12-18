# Gunakan base image dari registry Docker Hub yang mengandung sistem operasi dan runtime yang dibutuhkan
FROM node:14
FROM python:3.9

# Set working directory di dalam kontainer
WORKDIR /CC

# Salin file-dependensi aplikasi (misalnya, package.json dan package-lock.json) ke dalam kontainer
COPY package.json ./

# Install dependensi aplikasi
RUN npm install
RUN pip install --no-cache-dir -r requirements.txt

# Salin semua file aplikasi ke dalam kontainer
COPY . .

# Expose port yang digunakan oleh aplikasi
EXPOSE 4000
EXPOSE 5000

# Definisikan perintah yang akan dijalankan ketika kontainer dijalankan
CMD ["npm", "start"]
CMD ["python", "app.py"]