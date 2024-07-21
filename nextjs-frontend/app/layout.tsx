"use client";

import "styles/globals.css";
import { ReactNode } from "react";
import Provider from "./Provider";
import Header from "@elements/header";
import { QueryClient, QueryClientProvider } from "@tanstack/react-query";

interface IProps {
  children: ReactNode;
}
export default function RootLayout({ children }: IProps) {
  const queryClient = new QueryClient();
  return (
    <html lang="en">
      <body>
        <Provider>
        <QueryClientProvider client={queryClient}>
          {/* <AppBar /> */}
          <Header />
          <div className={"  min-h-screen "}>{children}</div>
          </QueryClientProvider>
        </Provider>
      </body>
    </html>
  );
}
