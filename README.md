# My Profile App - Tugas 3 PAM

Aplikasi profil mahasiswa yang dibangun menggunakan framework **Compose Multiplatform**. Project ini mendemonstrasikan implementasi dasar UI deklaratif, tata letak (layout), dan komponen UI modern sesuai materi pertemuan ke-3.

## Identitas Mahasiswa
* **Nama:** Gian Ivander
* **NIM:** 123140040
* **Program Studi:** Teknik Informatika
* **Instansi:** Institut Teknologi Sumatera

## Deskripsi Project
Project ini bertujuan untuk membangun antarmuka pengguna (UI) yang konsisten di berbagai platform (Android/Desktop) menggunakan **Kotlin Multiplatform**. Fokus utama tugas ini adalah penerapan paradigma deklaratif, di mana UI dideskripsikan sebagai fungsi yang merespons state.

## Implementasi Teknis (Berdasarkan Materi 3)

### 1. Layouting & Positioning
* **Column:** Digunakan untuk menyusun elemen secara vertikal dari atas ke bawah (Profile Header -> Bio -> Card -> Button).
* **Row:** Digunakan di dalam InfoItem untuk menyusun Icon dan teks secara horizontal (kiri ke kanan).
* **Box:** Digunakan untuk menumpuk elemen (stacking), seperti background lingkaran di bawah foto profil.

### 2. UI Components
* **Text:** Menampilkan data statis seperti Nama, NIM, dan deskripsi bio.
* **Button:** Tombol interaktif "Edit Profile" dengan custom shape rounded corner.
* **Image:** Menampilkan foto profil menggunakan painterResource dengan ContentScale.Crop.
* **Card:** Sebagai container informasi kontak dengan efek elevasi untuk memberikan kesan kedalaman.
* **Icon:** Menggunakan Material Icons standar untuk Email, Call, dan Location.

### 3. Modifiers
* **Styling:** Menggunakan Modifier.clip(CircleShape) untuk foto profil melingkar.
* **Background:** Implementasi Brush.verticalGradient untuk memberikan tampilan visual yang modern (Gradasi Biru).
* **Spacing:** Penggunaan padding dan Spacer untuk menjaga jarak antar elemen sesuai prinsip desain UI yang rapi.
* **Weight:** Menggunakan Modifier.weight(1f) untuk mengisi sisa ruang kosong sehingga tombol berada di posisi bawah.

### 4. Reusable Composables
Kode diorganisir ke dalam fungsi-fungsi modular yang dapat digunakan kembali:
* **ProfileHeader()**: Mengelola tampilan foto profil dan nama.
* **ProfileCard()**: Mengelola container informasi.
* **InfoItem()**: Komponen generik untuk menampilkan baris informasi (Icon + Label + Value).

## Cara Menjalankan
1. Clone repository ini.
2. Buka project menggunakan **Android Studio**.
3. Pastikan Gradle Sync berhasil.
4. Jalankan pada emulator Android atau Desktop JVM.