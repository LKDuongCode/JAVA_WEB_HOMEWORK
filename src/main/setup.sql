create database ss18;
use ss18;


insert into account (username, password, email, phone, role, status)
values ('tuananh123', '12345678', 'tuananh123@gmail.com', '0912345678', 'CUSTOMER', 'ACTIVE'),
       ('hoanglong', 'longpass01', 'hoanglong@gmail.com', '0987654321', 'ADMIN', 'ACTIVE'),
       ('linh.nguyen', 'linh2004', 'linhnguyen04@gmail.com', '0977332233', 'CUSTOMER', 'INACTIVE'),
       ('phongtran', 'passphong', 'phong.tran@gmail.com', '0968123456', 'CUSTOMER', 'ACTIVE'),
       ('myduyen', 'duyenmy2023', 'myduyen23@gmail.com', '0932445566', 'CUSTOMER', 'ACTIVE'),
       ('khanhvu', 'vu_khanh99', 'khanhvu99@gmail.com', '0944332211', 'ADMIN', 'INACTIVE'),
       ('huyenle', 'huyenle88', 'huyenle88@gmail.com', '0909123456', 'CUSTOMER', 'ACTIVE'),
       ('minhphuc', 'phucphucphuc', 'minhphuc@gmail.com', '0921123344', 'CUSTOMER', 'ACTIVE'),
       ('bao.tran', 'tranbao01', 'baotran01@gmail.com', '0933556677', 'CUSTOMER', 'INACTIVE'),
       ('an.nguyen', 'anpass123', 'annguyen@gmail.com', '0955667788', 'CUSTOMER', 'ACTIVE');


INSERT INTO product (name, description, price, quantity, image)
VALUES ('Tai nghe Bluetooth', 'Tai nghe không dây chất lượng cao', 550000, 100, 'laptop_image.jpg'),
       ('Chuột gaming', 'Chuột chơi game có LED RGB', 650000, 150, 'laptop_image.jpg'),
       ('Bàn phím cơ', 'Bàn phím cơ Blue Switch', 950000, 80, 'laptop_image.jpg'),
       ('Màn hình 24 inch', 'Màn hình Full HD 24 inch', 3200000, 60, 'laptop_image.jpg'),
       ('Loa bluetooth', 'Loa mini di động có mic', 420000, 70, 'laptop_image.jpg'),
       ('Ổ cứng SSD 500GB', 'SSD tốc độ cao', 1350000, 90, 'laptop_image.jpg'),
       ('Webcam Full HD', 'Camera cho học online', 780000, 65, 'laptop_image.jpg'),
       ('Đèn LED bàn học', 'Đèn LED điều chỉnh ánh sáng', 270000, 200, 'laptop_image.jpg'),
       ('Cáp sạc nhanh', 'Cáp sạc USB-C PD 60W', 120000, 300, 'laptop_image.jpg'),
       ('Giá đỡ laptop', 'Đế nâng laptop chống mỏi cổ', 290000, 150, 'laptop_image.jpg');


insert into bill (totalMoney, created_at, account_id, status)
values (1350000, '2024-05-01 10:30:00', 1, 'PENDING'),
       (550000, '2024-05-02 14:20:00', 3, 'CONFIRMED'),
       (780000, '2024-05-03 09:15:00', 4, 'DELIVERING'),
       (950000, '2024-05-04 11:00:00', 5, 'COMPLETED'),
       (270000, '2024-05-05 17:45:00', 6, 'CANCELLED'),
       (290000, '2024-05-06 13:30:00', 7, 'PENDING'),
       (3200000, '2024-05-07 08:50:00', 8, 'CONFIRMED'),
       (120000, '2024-05-08 19:10:00', 9, 'DELIVERING'),
       (420000, '2024-05-09 15:25:00', 10, 'COMPLETED'),
       (650000, '2024-05-10 12:40:00', 2, 'CANCELLED');


insert into order_detail (product_id, bill_id, quantity, price)
values (1, 1, 2, 1100000), -- Tai nghe
       (6, 1, 1, 250000),  -- SSD
       (1, 2, 1, 550000),
       (7, 3, 1, 780000),
       (3, 4, 1, 950000),
       (8, 5, 1, 270000),
       (10, 6, 1, 290000),
       (4, 7, 1, 3200000),
       (9, 8, 2, 240000),
       (5, 9, 1, 420000),
       (2, 10, 1, 650000),


       (3, 1, 1, 950000),
       (9, 1, 2, 240000),
       (4, 2, 1, 3200000),
       (5, 3, 2, 840000),
       (8, 4, 1, 270000),
       (10, 5, 1, 290000),
       (6, 6, 1, 1350000),
       (2, 7, 1, 650000),
       (7, 8, 1, 780000);
