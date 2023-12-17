# Gunakan base image dari registry Docker Hub yang mengandung sistem operasi dan runtime yang dibutuhkan
FROM node:14

# Set working directory di dalam kontainer
WORKDIR /CC

# Salin file-dependensi aplikasi (misalnya, package.json dan package-lock.json) ke dalam kontainer
COPY package.json ./

# Install dependensi aplikasi
RUN npm install

# Salin semua file aplikasi ke dalam kontainer
COPY . .

# Expose port yang digunakan oleh aplikasi
EXPOSE 4000

# Definisikan perintah yang akan dijalankan ketika kontainer dijalankan
CMD ["npm", "start"]