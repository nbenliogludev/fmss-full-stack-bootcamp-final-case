interface AuthInputProps extends React.InputHTMLAttributes<HTMLInputElement> {
    id?: string;
    name?: string;
    type?: string;
    required?: boolean;
    autoComplete?: string;
    className?: string;
}

const AuthInput: React.FC<AuthInputProps> = ({
    id = 'input',
    name = 'input',
    type = 'text',
    required = false,
    autoComplete = 'off',
    className = '',
    ...rest
}) => {
    return (
        <input
            id={id}
            name={name}
            type={type}
            required={required}
            autoComplete={autoComplete}
            className={`block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6 ${className}`}
            {...rest}
        />
    );
};

export default AuthInput;
