from flask import Flask, request, jsonify
from google.cloud import storage

app = Flask(__name__)
bucket_name = 'matching-job-pdf'

# Konfigurasi Google Cloud Storage
def upload_to_gcs(file_storage, filename):
     client = storage.Client()
     bucket = client.bucket(bucket_name)
     blob = bucket.blob(filename)
     blob.upload_from_string(file_storage.read(), content_type='application/pdf')
     return f"File {filename} berhasil diunggah ke Google Cloud Storage."

# API Endpoint untuk mengunggah file PDF
@app.route('/upload-pdf', methods=['POST'])
def upload_pdf():
     if 'file' not in request.files:
          return jsonify({'error': 'File not found'}), 400

     uploaded_file = request.files['file']
     if uploaded_file.filename == '':
          return jsonify({'error': 'Invalid file'}), 400

     if uploaded_file and uploaded_file.filename.endswith('.pdf'):
          filename = uploaded_file.filename
          result = upload_to_gcs(uploaded_file, filename)
          return jsonify({'message': result}), 200
     else:
          return jsonify({'error': 'File must be a PDF'}), 400

if __name__ == '__main__':
     app.run(debug=True)