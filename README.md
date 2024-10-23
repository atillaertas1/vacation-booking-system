
# Tatil Rezervasyon Sistemi

Bu proje, **Veritabanı Yönetim Sistemleri** dersi kapsamında geliştirilen bir tatil rezervasyon platformudur. Kullanıcılar tatil yerlerini arayabilir, rezervasyon yapabilir ve ziyaret ettikleri yerler hakkında yorum bırakabilir. Ayrıca, yöneticiler tatil yerlerini ve rezervasyonları yönetebilir.

## İçindekiler

- [Özellikler](#özellikler)
- [Kullanılan Teknolojiler](#kullanılan-teknolojiler)
- [Kurulum](#kurulum)
- [API Endpointleri](#api-endpointleri)
- [Veritabanı Tasarımı](#veritabanı-tasarımı)
- [Veritabanı Yönetim Sistemleri Dersi Amaçları](#veritabanı-yonetim-sistemleri-dersi-amaçları)
- [Katkıda Bulunma](#katkıda-bulunma)

## Özellikler

- **Kullanıcı Yönetimi**: Kullanıcılar kayıt olabilir, bilgilerini güncelleyebilir ve kullanıcı profillerini silebilir.
- **Tatil Yeri Yönetimi**: Yöneticiler yeni tatil yerleri ekleyebilir, güncelleyebilir veya silebilir.
- **Rezervasyon Sistemi**: Kullanıcılar tatil yerleri için rezervasyon yapabilir, rezervasyonlarını güncelleyebilir veya iptal edebilir.
- **Yorum Sistemi**: Kullanıcılar, tatil yerlerine yorum ekleyebilir ve mevcut yorumları inceleyebilir.
- **Resim Yönetimi**: Yöneticiler tatil yerleri için resim yükleyebilir ve resimleri yönetebilir.

## Kullanılan Teknolojiler

- **Backend**: 
  - Spring Boot (Spring Web, Spring Data JPA, Spring Security, Lombok)
  - Hibernate (JPA)
- **Veritabanı**: 
  - PostgreSQL
- **Araçlar**:
  - Maven
  - Postman (API testleri için)
  - pgAdmin (Veritabanı yönetimi için)

## Kurulum

### Gereksinimler:
- Java 17+
- PostgreSQL
- Maven

### Adımlar:

1. **Projeyi Klonlayın**:
   ```bash
   git clone https://github.com/atillaertas1/vacation-booking-system.git
   cd vacation-booking-system
   ```

2. **Veritabanını Ayarlayın**: PostgreSQL'de bir veritabanı oluşturun.
   ```sql
   CREATE DATABASE vacation_booking_db;
   ```

3. **Uygulama Ayarlarını Yapın**: `src/main/resources/application.properties` dosyasındaki veritabanı bilgilerini kendi PostgreSQL ayarlarınızla güncelleyin.
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/vacation_booking_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

4. **Proje Bağımlılıklarını Yükleyin**:
   ```bash
   mvn clean install
   ```

5. **Uygulamayı Başlatın**:
   ```bash
   mvn spring-boot:run
   ```

6. **Postman Kullanarak API Testleri Yapın**: Aşağıda belirtilen endpointler üzerinden Postman ile testler gerçekleştirin.

## API Endpointleri

### Kullanıcılar (Users)
| Yöntem | Endpoint              | Açıklama                                        |
|--------|-----------------------|------------------------------------------------|
| POST   | `/api/users`           | Yeni bir kullanıcı oluşturur                   |
| GET    | `/api/users`           | Tüm kullanıcıları listeler                     |
| GET    | `/api/users/{id}`      | Belirtilen ID'ye sahip kullanıcıyı getirir    |
| PUT    | `/api/users/{id}`      | Belirtilen ID'ye sahip kullanıcının bilgilerini günceller |
| DELETE | `/api/users/{id}`      | Belirtilen ID'ye sahip kullanıcıyı siler      |

### Tatil Yerleri (Vacation Spots)
| Yöntem | Endpoint              | Açıklama                                        |
|--------|-----------------------|------------------------------------------------|
| POST   | `/api/spots`           | Yeni bir tatil yeri oluşturur                  |
| GET    | `/api/spots`           | Tüm tatil yerlerini listeler                   |
| GET    | `/api/spots/{id}`      | Belirtilen ID'ye sahip tatil yerinin detaylarını getirir |
| PUT    | `/api/spots/{id}`      | Belirtilen ID'ye sahip tatil yerini günceller  |
| DELETE | `/api/spots/{id}`      | Belirtilen ID'ye sahip tatil yerini siler      |
| GET    | `/api/spots/search`    | Belirtilen konuma göre tatil yerlerini arar    |

### Rezervasyonlar (Reservations)
| Yöntem | Endpoint                | Açıklama                                      |
|--------|-------------------------|----------------------------------------------|
| POST   | `/api/reservations`      | Yeni bir rezervasyon oluşturur               |
| GET    | `/api/reservations`      | Tüm rezervasyonları listeler                 |
| GET    | `/api/reservations/{id}` | Belirtilen ID'ye sahip rezervasyonun detaylarını getirir |
| PUT    | `/api/reservations/{id}` | Belirtilen ID'ye sahip rezervasyonu günceller |
| DELETE | `/api/reservations/{id}` | Belirtilen ID'ye sahip rezervasyonu siler     |

### Yorumlar (Reviews)
| Yöntem | Endpoint              | Açıklama                                        |
|--------|-----------------------|------------------------------------------------|
| POST   | `/api/reviews`         | Yeni bir yorum oluşturur                       |
| GET    | `/api/reviews`         | Tüm yorumları listeler                         |
| GET    | `/api/reviews/{id}`    | Belirtilen ID'ye sahip yorumun detaylarını getirir |
| PUT    | `/api/reviews/{id}`    | Belirtilen ID'ye sahip yorumu günceller        |
| DELETE | `/api/reviews/{id}`    | Belirtilen ID'ye sahip yorumu siler            |

### Admin İşlemleri (Admin Actions)
| Yöntem | Endpoint              | Açıklama                                        |
|--------|-----------------------|------------------------------------------------|
| POST   | `/api/admin/actions`   | Yeni bir admin işlemi oluşturur                |
| GET    | `/api/admin/actions`   | Tüm admin işlemlerini listeler                 |
| GET    | `/api/admin/actions/{id}` | Belirtilen ID'ye sahip admin işleminin detaylarını getirir |
| DELETE | `/api/admin/actions/{id}` | Belirtilen ID'ye sahip admin işlemini siler   |

### Tatil Yeri Resimleri (Vacation Spot Images)
| Yöntem | Endpoint                       | Açıklama                                   |
|--------|--------------------------------|-------------------------------------------|
| POST   | `/api/spots/{spotId}/images`    | Belirtilen tatil yerine resim ekler     |
| GET    | `/api/spots/{spotId}/images`    | Belirtilen tatil yerinin tüm resimlerini listeler |
| DELETE | `/api/spots/images/{imageId}`    | Belirtilen resimi siler                   |

## Veritabanı Tasarımı

Veritabanı yapısı şu şekildedir:

- **Kullanıcılar (Users)**
- **Tatil Yerleri (Vacation Spots)**
- **Rezervasyonlar (Reservations)**
- **Yorumlar (Reviews)**
- **Admin İşlemleri (Admin Actions)**
- **Tatil Yeri Resimleri (Vacation Spot Images)**

### Veritabanı İlişkileri
- Bir kullanıcı birden fazla rezervasyon yapabilir.
- Bir kullanıcı birçok tatil yeri ekleyebilir.
- Tatil yerleriyle kullanıcılar arasında **Many-to-One** ilişkisi vardır.
- Yorumlar, tatil yerlerine bağlıdır.


