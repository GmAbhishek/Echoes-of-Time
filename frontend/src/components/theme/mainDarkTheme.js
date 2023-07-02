import { createTheme } from "@mui/material";

const typography = {
  h1: {
    fontFamily: "Poppins",
  },
  h2: {
    fontFamily: "Poppins",
  },
  h3: {
    fontFamily: "Poppins",
  },
  h4: {
    fontFamily: "Poppins",
  },
  h5: {
    fontFamily: "Poppins",
  },
  h6: {
    fontFamily: "Poppins",
  },
};

const palette = {
  type: "dark",
  primary: {
    main: "#100C0C",
    light: "#DDDDDD",
    contrastText: "rgba(255,255,255,1)",
  },
  secondary: {
    main: "#2b2b36",
  },
  background: {
    default: "#2b2b36",
  },
  success: {
    main: "#2b2b36",
    contrastText: "#FFFFFF",
  },
};

export const mainDarkTheme = createTheme({
  typography: typography,
  palette: palette
});