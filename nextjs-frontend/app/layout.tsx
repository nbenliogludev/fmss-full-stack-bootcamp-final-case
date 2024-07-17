import "styles/globals.css";
import { ReactNode } from "react";
import AppBar from "./AppBar";
import Provider from "./Provider";
import Header from "@elements/header";

interface IProps {
  children: ReactNode;
}
export default function RootLayout({ children }: IProps) {
  return (
    <html lang="en">
      <body>
        <Provider>
          {/* <AppBar /> */}
          <Header />
          <div className={"  min-h-screen "}>{children}</div>
        </Provider>
      </body>
    </html>
  );
}
