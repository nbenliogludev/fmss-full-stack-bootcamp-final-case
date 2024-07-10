"use client";

import { Inter } from "next/font/google";
import "./globals.css";
import Header from "@/components/header";
import React from "react";
import { usePathname } from "next/navigation";

const inter = Inter({ subsets: ["latin"] });


export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  
  const pathname = usePathname();

  // Check if current path is login or register
  const shouldHideHeader = pathname === '/login' || pathname === '/register';

  return (
    <html lang="en">
      <body className={inter.className}>
        {!shouldHideHeader && <Header />}
        {children}
      </body>
    </html>
  );
}
